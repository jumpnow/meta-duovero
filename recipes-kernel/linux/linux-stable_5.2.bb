require linux-stable.inc

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

COMPATIBLE_MACHINE = "duovero"

KERNEL_DEVICETREE ?= "omap4-duovero-parlor.dtb"

LINUX_VERSION = "5.2"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

S = "${WORKDIR}/git"

PV = "5.2.11"
SRCREV = "c3915fe1bf1235dbf3b0bced734c960202915bd5"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-${LINUX_VERSION}.y \
    file://defconfig \
    file://0001-spidev-Add-spidev-compatible-id.patch \
    file://0002-mwifiex-Skip-unsupported-CHAN_REGION_CFG-cmd.patch \
    file://0003-mwifiex-Remove-unsupported-GTK_REKEY_OFFLOAD_CFG-cmd.patch \
"
