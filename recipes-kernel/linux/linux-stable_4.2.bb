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

PR = "r4"

# v4.2.6
SRCREV = "1c02865136fee1d10d434dc9e3616c8e39905e9b"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.2.y \
    file://defconfig \
    file://0001-spidev-Add-generic-compatible-id.patch \
    file://0002-duovero-Add-spi1-spidev-dtsi.patch \
    file://0003-duovero-Add-spi4-spidev-dtsi.patch \
    file://0004-kernel-Add-some-custom-dts-files.patch \
 "

