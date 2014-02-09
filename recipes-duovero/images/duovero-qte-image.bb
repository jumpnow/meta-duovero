SUMMARY = "A development image with Qt embedded, gstreamer1.0 and some Syntro apps"
HOMEPAGE = "http://www.pansenti.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

require duovero-console-image.bb

PR = "0"

QT_TOOLS = " \
    qt4-embedded-dev\
    qt4-embedded \
 "

GST_TOOLS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-omx \
    libomxil \
    libomxil-dev \
    libomxil-staticdev \
 "

SYNTRO = " \
    syntrocore \
    syntrocore-dev \
    syntrolcam \
    syntrolcam-init \
 "

IMAGE_INSTALL += " \
    ${GST_TOOLS} \
    ${QT_TOOLS} \
    ${SYNTRO} \
 "

export IMAGE_BASENAME = "duovero-qte-image"

