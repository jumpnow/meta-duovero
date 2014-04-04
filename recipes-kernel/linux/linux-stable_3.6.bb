require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "duovero"

# for identification
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-jumpnow-3.6:"

S = "${WORKDIR}/git"

# patches 0001-0010 are from meta-gumstix
# patches 0011-0014 are local

# v3.6.11 = b2824f4e0990716407b0c0e7acee75bb6353febf
SRCREV = "b2824f4e0990716407b0c0e7acee75bb6353febf"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.6.y \
    file://defconfig \
    file://0001-omap4-add-duovero-support.patch \
    file://0002-HACK-temporary-hack-to-use-cold-sw-reset-instead-of-.patch \
    file://0003-duovero-add-back-omap4_mux_init.patch \
    file://0004-perf-hard-code-NO_LIBPERL-NO_LIBPYTHON.patch \
    file://0005-duovero-invert-sense-of-card-detect-signal.patch \
    file://0006-Add-delay-to-the-smsc911x-driver.patch \
    file://0007-Support-duovero-zephyr.patch \
    file://0008-Pull-in-some-HDMI-mux-fixes-from-Panda.patch \
    file://0009-ARM-7668-1-fix-memset-related-crashes-caused-by-rece.patch \
    file://0010-ARM-7670-1-fix-the-memset-fix.patch \
    file://0011-Bluetooth-btmrvl-release-lock-while-waiting-for-fw-d.patch \
    file://0012-Bluetooth-btmrvl-report-error-if-verify_fw_download-.patch \
    file://0013-ARM-OMAP4-TWL-mux-sys_drm_msecure-as-output-for-PMIC.patch \
    file://0014-Enable-RTC-backup-battery-charging.patch \
    file://db.txt \
 "

do_configure_prepend() {
	cp ${WORKDIR}/db.txt ${S}/net/wireless
}

