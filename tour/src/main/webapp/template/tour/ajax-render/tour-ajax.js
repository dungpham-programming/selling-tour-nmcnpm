const tourUrl = `http://localhost:8080/tour`;

$(() => {
    $.ajax({
        url: tourUrl,
        type: 'GET',
        success: (tourList) => {
            renderToursUI(tourList);
        },
        error: (xhr, status, error) => {
            // Xử lý lỗi (nếu có)
            console.error(xhr.responseText);
        }
    });
});

function renderToursUI(tourList) {
    
}