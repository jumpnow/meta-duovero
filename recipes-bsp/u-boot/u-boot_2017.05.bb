require u-boot.inc

# FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot-2017.05:"

PV = "2017.05"
PR = "r0"

COMPATIBLE_MACHINE = "duovero"

UBOOT_LOCALVERSION = "-jumpnow"

SRCREV = "64c4ffa9fa223f7ae8640f9c8f3044bfa0e3bfda"
SRC_URI = " \
    git://git.denx.de/u-boot.git;branch=master;protocol=git \
 "

SPL_BINARY = "MLO"
