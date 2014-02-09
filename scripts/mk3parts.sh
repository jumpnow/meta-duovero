#!/bin/bash
#
# (c) Copyright 2012 Scott Ellis <scott@pansenti.com>
# Licensed under terms of GPLv2
#
# Based in large on the mksdcard.sh script from Steve Sakoman
# http://www.sakoman.com/category/3-bootable-sd-microsd-card-creation-script.html
#

if [ -n "$1" ]; then
	DRIVE=/dev/$1
else
	echo -e "\nUsage: sudo $0 <device>\n"
	echo -e "Example: sudo $0 sdb\n"
	exit 1
fi

if [ "$DRIVE" = "/dev/sda" ] ; then
	echo "Sorry, not going to format $DRIVE"
	exit 1
fi


echo -e "\nWorking on $DRIVE\n"

#make sure that the SD card isn't mounted before we start
if [ -b ${DRIVE}1 ]; then
	umount ${DRIVE}1
	umount ${DRIVE}2
	umount ${DRIVE}3
elif [ -b ${DRIVE}p1 ]; then
	umount ${DRIVE}p1
	umount ${DRIVE}p2
	umount ${DRIVE}p3
else
	umount ${DRIVE}
fi


SIZE=`fdisk -l $DRIVE | grep "Disk $DRIVE" | cut -d' ' -f5`

echo DISK SIZE – $SIZE bytes

if [ "$SIZE" -lt 4000000000 ]; then
	echo "Require an SD card of at least 4GB"
	exit 1
fi

CYLINDERS=`echo $SIZE/255/63/512 | bc`

echo CYLINDERS – $CYLINDERS

echo -e "\nOkay, here we go ...\n"

echo -e "=== Zeroing the MBR ===\n"
dd if=/dev/zero of=$DRIVE bs=1024 count=1024

# Three partition build. Creates a third partition convenient for mounting 
# the Gumstix as a mass-storage device on another machine.
# Sectors are 512 bytes
# 64 MB = 67108864 bytes = 131072 sectors
# 2 GB = 2147483648 bytes = 4194304 sectors
# MBR goes in first sector
# Next 127 sectors are empty to align first partition on a 128 sector boundary
# First partition starts at sector 128 and goes for 130944 sectors, FAT32
# Second partition starts at sector 131072 and goes for 4194304 sectors, Linux
# Third partition starts at 4325376 and goes to end of card, FAT32

echo -e "\n=== Creating 3 partitions ===\n"
{
echo 128,130944,0x0C,*
echo 131072,4194304,0x83,-
echo 4325376,+,0x0C,-
} | sfdisk --force -D -uS -H 255 -S 63 -C $CYLINDERS $DRIVE


sleep 1

echo -e "\n=== Done! ===\n"

