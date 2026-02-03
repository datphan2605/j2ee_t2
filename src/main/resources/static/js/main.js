// Gọi API từ Java để lấy danh sách sách
fetch('/api/books')
    .then(response => response.json())
    .then(books => {
        // Tìm cái bảng trong HTML
        const tableBody = document.querySelector('#bang-sach tbody');

        // Xóa dữ liệu cũ (nếu có) để tránh bị trùng lặp khi load lại
        tableBody.innerHTML = '';

        // Duyệt qua từng cuốn sách và tạo dòng (row) mới
        books.forEach(book => {
            const row = `
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                </tr>
            `;
            tableBody.innerHTML += row;
        });
    })
    .catch(error => console.error('Lỗi kết nối:', error));