require linux-stable.inc

COMPATIBLE_MACHINE = "duovero"

KERNEL_DEVICETREE ?= "omap4-duovero-parlor.dtb"

LINUX_VERSION = "4.19"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

S = "${WORKDIR}/git"

PV = "4.19.98"
SRCREV = "d183c8e2647a7d45202c14a33631f6c09020f8ac"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-${LINUX_VERSION}.y \
    file://defconfig \
    file://0001-spidev-Add-spidev-compatible-id.patch \
    file://0002-mwifiex-Skip-unsupported-CHAN_REGION_CFG-cmd.patch \
    file://0003-mwifiex-Remove-unsupported-GTK_REKEY_OFFLOAD_CFG-cmd.patch \
"
