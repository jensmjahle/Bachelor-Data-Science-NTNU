

// Funksjon for å øke et tall med 1 for hvert klikk
let counter = 0;
function increaseCounter() {
    counter++;
    document.getElementById('counterResult').innerText = counter;
}

// Funksjon for å skjule/vis innholdet
function toggleContent() {
    const contentBlock = document.getElementById('toggleContentBlock');
    contentBlock.style.display = contentBlock.style.display === 'none' ? 'block' : 'none';
}

// Opprett et array med tilfeldige stikkord og vis det som en liste
function displayKeywords() {
    const keywords = ['JavaScript', 'HTML', 'CSS', 'Web Development', 'Front-end', 'Back-end'];
    const listContainer = document.getElementById('keywordsList');

    keywords.forEach(keyword => {
        const listItem = document.createElement('li');
        listItem.textContent = keyword;
        listContainer.appendChild(listItem);
    });
}

