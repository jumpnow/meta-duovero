FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://db.txt \
            file://0011-Bluetooth-btmrvl-release-lock-while-waiting-for-fw-d.patch \
            file://0012-Bluetooth-btmrvl-report-error-if-verify_fw_download-.patch \
           "

do_configure_prepend() {
	cp ${WORKDIR}/db.txt ${S}/net/wireless
}

