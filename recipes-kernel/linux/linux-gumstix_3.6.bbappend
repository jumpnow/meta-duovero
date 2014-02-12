FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://db.txt \
            file://0011-Bluetooth-btmrvl-release-lock-while-waiting-for-fw-d.patch \
            file://0012-Bluetooth-btmrvl-report-error-if-verify_fw_download-.patch \
            file://0013-ARM-OMAP4-TWL-mux-sys_drm_msecure-as-output-for-PMIC.patch \
            file://0014-Enable-RTC-backup-battery-charging.patch \
           "

do_configure_prepend() {
	cp ${WORKDIR}/db.txt ${S}/net/wireless
}

