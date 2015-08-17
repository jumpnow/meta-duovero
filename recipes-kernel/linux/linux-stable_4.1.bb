require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_duovero = " \
    omap4-duovero-parlor.dtb \
    jumpnow-duovero-parlor.dtb \
    jumpnow-duovero-parlor-nodisplay.dtb \
 "

LINUX_VERSION = "4.1"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.1:"

S = "${WORKDIR}/git"

PR = "r7"

# v4.1.6
SRCREV = "4ff62ca06c0c0b084f585f7a2cfcf832b21d94fc"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.1.y \
    file://defconfig \
    file://0001-spidev-Add-generic-compatible-dt-id.patch \
    file://0002-duovero-Add-spi1-spidev-dtsi.patch \
    file://0003-duovero-Add-spi4-spidev-dtsi.patch \
    file://0004-kernel-Add-some-custom-dts-files.patch \
 "

