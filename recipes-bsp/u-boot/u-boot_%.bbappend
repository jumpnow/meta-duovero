FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-Add-bootargs-setting.patch \
            file://0002-Customize-defconfig.patch \
           "

UBOOT_SUFFIX = "img"
SPL_BINARY = "MLO"
