UBOOT_SUFFIX = "img"
SPL_BINARY = "MLO"

UBOOT_LOCALVERSION = "-jumpnow"

require u-boot-common.inc
require u-boot.inc

SRC_URI += "file://0001-Hardcode-bootcmd-for-sd-card.patch"

DEPENDS += "bc-native dtc-native"
