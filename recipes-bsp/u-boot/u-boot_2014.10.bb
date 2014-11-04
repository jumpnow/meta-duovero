require u-boot.inc

PV = "2014.10"

COMPATIBLE_MACHINE = "duovero"

# for identification
UBOOT_LOCALVERSION = "-jumpnow"

# v2014.10
SRCREV = "c43fd23cf619856b0763a64a6a3bcf3663058c49"
SRC_URI = " \
    git://git.denx.de/u-boot.git;branch=master;protocol=git \
 "

SPL_BINARY = "MLO"

