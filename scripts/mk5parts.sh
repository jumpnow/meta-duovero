#!/bin/sh
# 
# Create 5 partitions for use with root-upgrader

function ver() {
        printf "%03d%03d%03d" $(echo "$1" | tr '.' ' ')
}

if [ -n "$1" ]; then
        DEV=/dev/$1
else
        echo -e "\nUsage: sudo $0 <device>\n"
        echo -e "Example: sudo $0 sdb\n"
        exit 1
fi

mount | grep '^/' | grep -q ${1}

if [ $? -ne 1 ]; then
    echo "Looks like partitions on device /dev/${1} are mounted"
    echo "Not going to work on a device that is currently in use"
    mount | grep ${1}
    exit 1
fi

# new versions of sfdisk don't use rotating disk params
sfdisk_ver=`sfdisk --version | awk '{ print $4 }'`

if [ $(ver $sfdisk_ver) -lt $(ver 2.26.2) ]; then
        CYLINDERS=`echo $SIZE/255/63/512 | bc`
        echo CYLINDERS – $CYLINDERS
        SFDISK_CMD="sfdisk --force -D -uS -H255 -S63 -C ${CYLINDERS}"
else
        SFDISK_CMD="sfdisk"
fi

echo -e "\nOkay, here we go ...\n"

echo -e "=== Zeroing the MBR ===\n"
dd if=/dev/zero of=$DEV bs=1024 count=1024

## 5 partitions
# Sectors are 512 bytes
# 0-127: 64KB, no partition, MBR
# p1: 64MB, FAT partition, bootloader
# p2: 1GB, linux partition, first root filesystem
# p3: 1GB, linux partition, second root filesystem
# p4: extended partition
# p5: 64MB, FAT partition
# p6: remainder of device, linux partition

echo -e "\n=== Creating 5 partitions ===\n"
{
echo 128,131072,0x0C,*
echo ,2097152,0x83,-
echo ,2097152,0x83,-
echo ,,E
echo ,131072,0x0C,-
echo ,+,0x83,-
} | $SFDISK_CMD $DEV

sleep 1

echo -e "\n=== Done! ===\n"

