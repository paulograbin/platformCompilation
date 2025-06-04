/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved
 */

// AdvancedSearchAdapter: adjust css for remove and add button

let advancedSearchAdapter;

class AdvancedSearch {
    hasScrollbar = () => {
        const advancedSearchContainer = $('.yw-com_hybris_backoffice_perspectiveContainer .yw-advancedsearch.yw-com_hybris_cockpitng_advancedsearch');
        if (advancedSearchContainer.length > 0) {
            return advancedSearchContainer[0].scrollHeight > advancedSearchContainer[0].clientHeight;
        }
        return false;
    };

    adjustStyle = (targetElementSelector, className) => {
        const targetElements = $(targetElementSelector);

        if (this.hasScrollbar()) {
            for (let i = 0; i < targetElements.length; i++) {
                targetElements.eq(i).addClass(className);
            }
        }
        else {
            for (let i = 0; i < targetElements.length; i++) {
                targetElements.eq(i).removeClass(className);
            }
        }
    };
}

function adjustPadding() {
    if (!advancedSearchAdapter) {
        advancedSearchAdapter = new AdvancedSearch();
    }

    const removeContainerSelector = '.yw-remove-container.z-div',
          addContainerSelector = '.yw-advancedsearch-add-btn.y-btn-transparent.cng-font-icon';

    const removeContainerScrollBarClass = 'yw-remove-container-scroll-bar',
        addContainerScrollBarClass = 'yw-advancedsearch-add-btn-scroll-bar';

    advancedSearchAdapter.adjustStyle(removeContainerSelector, removeContainerScrollBarClass);
    advancedSearchAdapter.adjustStyle(addContainerSelector, addContainerScrollBarClass);
}
