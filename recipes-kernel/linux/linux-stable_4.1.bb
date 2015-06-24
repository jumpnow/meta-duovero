require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel_base += "kernel-devicetree"

KERNEL_DEVICETREE_duovero = "omap4-duovero-parlor.dtb"

LINUX_VERSION = "4.1"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.1:"

S = "${WORKDIR}/git"

PR = "r1"

# v4.1 = b953c0d234bc72e8489d3bf51a276c5c4ec85345 
SRCREV = "b953c0d234bc72e8489d3bf51a276c5c4ec85345"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.1.y \
    file://defconfig \
    file://0001-spidev-Add-generic-compatible-dt-id.patch \
 "

