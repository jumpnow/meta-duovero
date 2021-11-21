#!/bin/bash
# 
# Create 5 partitions for use with root-upgrader

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

echo -e "\nOkay, here we go ...\n"

echo -e "=== Zeroing the MBR ===\n"
dd if=/dev/zero of=$DEV bs=1024 count=1024

## 3 partitions
# Sectors are 512 bytes
# 0-127: 64KB, no partition, MBR
# p1: 64MB, FAT partition, bootloader
# p2: 2GB, linux partition, root filesystem
# p3: remainder of device, linux partition

echo -e "\n=== Creating 3 partitions ===\n"
{
echo 128,131072,0x0C,*
echo ,4194304,0x83,-
echo ,+,0x83,-
} | sfdisk $DEV

sleep 1

echo -e "\n=== Done! ===\n"
