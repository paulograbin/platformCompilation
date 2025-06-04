/**
 * Set title attribute for element that modified with selector in component
 *
 * @param {Object} component: html component
 * @param {string} selector: element selector
 * @param {string} title: title value
 *
 */
const setTitleForIcon = (component, selector, title) => {
    const jqBtns = jq(component.$n()).find(selector);

    for (const jqBtn of jqBtns) {
        if (jqBtn && !jqBtn.getAttribute('title')) {
            jqBtn.setAttribute('title', title);
        }
    }
};
