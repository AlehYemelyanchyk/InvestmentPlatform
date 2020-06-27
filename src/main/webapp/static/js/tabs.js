let tabs = document.querySelectorAll('[data-tab-target]')
let tabContent = document.querySelectorAll('[data-tab-content]')
let table

tabs.forEach(tab => {
    tab.addEventListener('click', () => {
        const target = document.querySelector(tab.dataset.tabTarget)
        table = target.getAttribute("id")
        table = "#" + table
        tabContent.forEach(tabContent => {
            tabContent.classList.remove('active')
        })
        tabs.forEach(tab => {
            tab.classList.remove('active')
        })
        tab.classList.add('active')
        target.classList.add('active')
    })
})