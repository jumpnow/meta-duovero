require recipes-kernel/linux/linux-yocto.inc

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE ?= "omap4-duovero-parlor.dtb"

LINUX_VERSION = "4.14"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

S = "${WORKDIR}/git"

PV = "4.14.24"
SRCREV = "6e4548ea58e6a5ed2dd3a417d991742e2dec0246"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-${LINUX_VERSION}.y \
    file://defconfig \
    file://0001-Revert-mfd-twl6040-The-chip-does-not-support-bulk-ac.patch \
    file://0002-spidev-Add-spidev-compatible-id.patch \
    file://0003-mwifiex-Skip-unsupported-CHAN_REGION_CFG-cmd.patch \
    file://0004-mwifiex-Remove-unsupported-GTK_REKEY_OFFLOAD_CFG-cmd.patch \
"
