require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE = " \
    omap4-duovero-parlor.dtb \
    jumpnow-duovero-parlor.dtb \
    jumpnow-duovero-parlor-nodisplay.dtb \
 "

LINUX_VERSION = "4.7"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.7:"

S = "${WORKDIR}/git"

PR = "r1"

# v4.7.2
SRCREV = "84fae3f89282ce86a0c0da30e35fe66dbcadda6f"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.7.y \
    file://defconfig \
    file://0001-spidev-Add-a-generic-compatible-id.patch \
    file://0002-Add-custom-dts-files.patch \
 "
