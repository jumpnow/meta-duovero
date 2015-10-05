require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_duovero = " \
    omap4-duovero-parlor.dtb \
    jumpnow-duovero-parlor.dtb \
    jumpnow-duovero-parlor-nodisplay.dtb \
 "

LINUX_VERSION = "4.2"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.2:"

S = "${WORKDIR}/git"

PR = "r2"

# v4.2.3
SRCREV = "fcba09f2b0bf27eeaa1d4d439edb649585f35040"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.2.y \
    file://defconfig \
    file://0001-spidev-Add-generic-compatible-id.patch \
    file://0002-duovero-Add-spi1-spidev-dtsi.patch \
    file://0003-duovero-Add-spi4-spidev-dtsi.patch \
    file://0004-kernel-Add-some-custom-dts-files.patch \
 "

