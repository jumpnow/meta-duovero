require u-boot.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot-2015.07:"

PV = "2015.07"
PR = "r2"

COMPATIBLE_MACHINE = "duovero"

# for identification
UBOOT_LOCALVERSION = "-jumpnow"

# v2015.07
SRCREV = "33711bdd4a4dce942fb5ae85a68899a8357bdd94"
SRC_URI = " \
    git://git.denx.de/u-boot.git;branch=master;protocol=git \
    file://0001-Load-uEnv.txt-from-boot-directory.patch \
    file://0002-Remove-boot-scr-support.patch \
 "

SPL_BINARY = "MLO"

