//document.addEventListener('DOMContentLoaded', function() {
//    // Navbar shadow on scroll
//    window.addEventListener('scroll', function() {
//        const navbar = document.getElementById('navbar');
//        if (window.scrollY > 10) {
//            navbar.style.boxShadow = '0 8px 20px rgba(0,0,0,0.2)';
//        } else {
//            navbar.style.boxShadow = '0 4px 12px rgba(0,0,0,0.1)';
//        }
//    });
//
//    // Fade-in animation
//    const mainContainers = document.querySelectorAll('center, .content-center, #myform, table');
//    mainContainers.forEach(el => {
//        el.style.opacity = '0';
//        el.style.transform = 'translateY(20px)';
//        el.style.transition = 'opacity 0.5s ease, transform 0.5s ease';
//        setTimeout(() => {
//            el.style.opacity = '1';
//            el.style.transform = 'translateY(0)';
//        }, 100);
//    });
//
//    // Form input focus effect
//    const inputs = document.querySelectorAll('input, select, textarea');
//    inputs.forEach(input => {
//        input.addEventListener('focus', () => {
//            input.parentElement.style.transform = 'scale(1.02)';
//        });
//        input.addEventListener('blur', () => {
//            input.parentElement.style.transform = 'scale(1)';
//        });
//    });
//
//    // Convert alert messages to stylish toasts
//    const successDiv = document.querySelector('div[style*="color:green"]');
//    const errorDiv = document.querySelector('div[style*="color:red"]');
//    if (successDiv) {
//        successDiv.className = 'alert-success';
//        setTimeout(() => { successDiv.style.display = 'none'; }, 3000);
//    }
//    if (errorDiv) {
//        errorDiv.className = 'alert-error';
//        setTimeout(() => { errorDiv.style.display = 'none'; }, 4000);
//    }
//
//    // Dynamic search for tables
//    const searchInput = document.createElement('input');
//    searchInput.type = 'text';
//    searchInput.placeholder = 'Search table...';
//    searchInput.style.margin = '10px auto';
//    searchInput.style.display = 'block';
//    searchInput.style.width = '80%';
//    searchInput.style.padding = '10px';
//    searchInput.style.borderRadius = '30px';
//    searchInput.style.border = '1px solid #ccc';
//    
//    const tables = document.querySelectorAll('table');
//    tables.forEach(table => {
//        if (table.querySelectorAll('tr').length > 2) {
//            table.parentNode.insertBefore(searchInput.cloneNode(true), table);
//            const searchBox = table.previousSibling;
//            searchBox.addEventListener('keyup', function() {
//                const filter = this.value.toLowerCase();
//                const rows = table.querySelectorAll('tbody tr');
//                rows.forEach(row => {
//                    const text = row.innerText.toLowerCase();
//                    row.style.display = text.includes(filter) ? '' : 'none';
//                });
//            });
//        }
//    });
//});