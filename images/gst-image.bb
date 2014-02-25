SUMMARY = "A development image with gstreamer1.0"
HOMEPAGE = "http://www.jumpnowtek.com"
LICENSE = "MIT"

require qte-image.bb

GST_TOOLS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-omx \
    libomxil \
    libomxil-dev \
    libomxil-staticdev \
 "

IMAGE_INSTALL += " \
    ${GST_TOOLS} \
 "

export IMAGE_BASENAME = "gst-image"

