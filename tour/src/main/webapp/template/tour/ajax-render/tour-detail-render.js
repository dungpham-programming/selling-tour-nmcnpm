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
    renderThumbnailTour(tour.images[0].url, tour.name);
    renderVehicleAndDestination(tour.travelTime, tour.vehicle, tour.starting, tour.destination);
    renderDescription(tour.description);
    renderImages(tour.images);
    renderTimeline(tour.timeline);
}

function renderThumbnailTour(imageUrl, tourName) {
    const background = $('.bg-breadcrumb');
    const bigTitle = $('h3.title');
    const detail = $('div.detail');

    background.css({
        'background': `linear-gradient(rgba(19, 53, 123, 0.5), rgba(19, 53, 123, 0.5)), url('${imageUrl}')`,
        'background-position': `center`,
        'background-repeat': `no-repeat`,
        'background-size': `cover`,
        'padding': `150px 0 50px 0`
    });

    bigTitle.text(tourName);
    detail.append(`<h1 class="mb-0">${tourName}</h1>`);
}

function renderVehicleAndDestination(travelTime, vehicle, starting, destination) {
    const info = $('.row-info');
    info.append(`
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12 d-flex justify-content-center">
                <span class="text-uppercase pe-1">Thời gian:</span>
                <span class="text-strong-color-black"> ${travelTime}</span>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12 d-flex justify-content-center">
                <span class="text-uppercase pe-1">Phương tiện:</span>
                <span class="text-strong-color-black"> ${vehicle}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12 d-flex justify-content-center">
                <span class="text-uppercase pe-1">Điểm xuất phát:</span>
                <span class="text-strong-color-black"> ${starting}</span>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12 d-flex justify-content-center">
                <span class="text-uppercase pe-1">Điểm đến:</span>
                <span class="text-strong-color-black"> ${destination}</span>
            </div>
        </div>
    `);
}

function renderDescription(description) {
    const container = $('.row-description');
    container.append(`
       <h4 class="title-description text-strong-color-black" style="margin-top: -50px;">Tour này có gì hay</h4>
       <div class="content-description" style="margin-top: -44px;">${description}</div>
    `);
}

function renderImages(images) {
    const imageBox = $('.image-box');
    for (const image of images) {
        imageBox.append(`
            <div class="col-md-4 col-sm-6 col-xs-12" style="margin-bottom: 25px">
                   <img width="100%" height="100%" alt="Image Tour" src="${image.url}">
            </div>
        `);
    }
}

function renderTimeline(timeline) {
    const timelineContainer = $('.timeline');
    timelineContainer.append(`${timeline}`);
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
