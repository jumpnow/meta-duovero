FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://db.txt"

do_configure_prepend() {
	cp ${WORKDIR}/db.txt ${S}/net/wireless
}

