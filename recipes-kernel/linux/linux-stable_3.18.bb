require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE = " \
    omap4-duovero-parlor.dtb \
 "

LINUX_VERSION = "3.18"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-3.18:"

S = "${WORKDIR}/git"

PR = "r1"

PV = "3.18.44"
SRCREV = "a6846cfd266b48af1ee7c3c19d5cb60477ca4469"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.18.y \
    file://defconfig \
    file://0001-duovero-Bind-vdac-regulator-to-hdmi-node.patch \
    file://0002-spidev-Add-a-generic-compatible-id.patch \
 "
