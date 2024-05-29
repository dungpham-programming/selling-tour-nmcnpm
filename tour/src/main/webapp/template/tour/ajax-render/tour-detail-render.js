const tourDetailUrl = `http://localhost:8080${contextPath}/api/tour-detail`;
const tourId = getUrlParameter('tourId');

$(() => {
    $.ajax({
        url: tourDetailUrl,
        type: 'GET',
        data: {
            tourId: tourId
        },
        success: (tour) => {
            renderTourDetailUI(tour);
        },
        error: (xhr, status, error) => {
            // Xử lý lỗi (nếu có)
            console.error(xhr.responseText);
        }
    });
});

function renderTourDetailUI(tour) {
    renderThumbnailTour(tour.images[0].url)
}

function renderThumbnailTour(imageUrl) {
    const background = $('.bg-breadcrumb');
    const textCenter = $('.container.text-center');

    background.css({
        background: `linear-gradient(rgba(19, 53, 123, 0.5), rgba(19, 53, 123, 0.5)), url('${imageUrl}')`
    });
}

function getUrlParameter(sParam) {
    let sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? '' : decodeURIComponent(sParameterName[1]);
        }
    }
    return '';
}
