FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://duovero-default-env.patch \
	    file://coherent-pool.patch \
	   "

