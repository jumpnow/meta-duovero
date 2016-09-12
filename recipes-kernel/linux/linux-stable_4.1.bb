require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE = " \
    omap4-duovero-parlor.dtb \
 "

LINUX_VERSION = "4.1"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.1:"

S = "${WORKDIR}/git"

PR = "r1"

# v4.1.32
SRCREV = "3b60b86aec06fbae1142ccc4e55b39b529ae2a25"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.1.y \
    file://defconfig \
    file://0001-spidev-Add-a-generic-compatible-id.patch \
 "
