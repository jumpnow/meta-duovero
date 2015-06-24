require u-boot.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot-2015.04:"

PV = "2015.04"
PR = "r1"

COMPATIBLE_MACHINE = "duovero"

# for identification
UBOOT_LOCALVERSION = "-jumpnow"

# v2015.04
SRCREV = "f33cdaa4c3da4a8fd35aa2f9a3172f31cc887b35"
SRC_URI = " \
    git://git.denx.de/u-boot.git;branch=master;protocol=git \
    file://0001-Load-uEnv.txt-from-boot-directory.patch \
    file://0002-Remove-boot-scr-support.patch \
 "

SPL_BINARY = "MLO"

