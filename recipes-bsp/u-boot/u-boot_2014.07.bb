require u-boot.inc

PV = "2014.07"

COMPATIBLE_MACHINE = "duovero"

# for identification
UBOOT_LOCALVERSION = "-jumpnow"

# v2014.07
SRCREV = "524123a70761110c5cf3ccc5f52f6d4da071b959"
SRC_URI = " \
    git://git.denx.de/u-boot.git;branch=master;protocol=git \
 "

SPL_BINARY = "MLO"

