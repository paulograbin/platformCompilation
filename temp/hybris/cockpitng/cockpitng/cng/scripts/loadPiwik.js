const TRACKING_URL = "https://license.hybris.com/collect";
const CLICK_TRACKING_KEY = "data-label-key";
const TITLE = "title";
const NAVIGATION_NODE_LEVEL1 = "tr.yw-navigationNode-level1";
const NAVIGATION_NODE_LEVEL2 = "tr.yw-navigationNode-level2";
const EXPLORER_TREE_LABEL = ".z-treecell-content .yw-treeCellInner .z-label";
const USER_PROFILE_BTN = "a.yw-userprofie-btn";
const USER_PROFILE_SETTINGS = "td.yw-profile-settings";
const USER_PROFILE_SIGNOUT = "td.yw-signout";

var _paq = _paq || [];

_paq.push(['disableCookies']);

_paq.push(["enableLinkTracking"]);
_paq.push(["setRequestMethod", "POST"]);

class NavigationNode {
    constructor(title, titleKey) {
        this.title = title;
        this.titleKey = titleKey;
    }
    reset = function () {
        this.title = "";
        this.titleKey = "";
    }
}

function embedTrackingCode(siteId) {
    _paq.push(["setTrackerUrl", TRACKING_URL]);
    _paq.push(["setSiteId", siteId]);

    loadPiwikLib();
    trackingExplorerTreeNavigation();
    trackingPerspectiveNavigation();
    trackingActionButtonNavigation();
    trackingShellBarActions();
    trackingUserProfileSettings();
}

/**
 * @param param, like: ["Login Type", "SSO", "i18nKey"]
 */
function sendTrackingRequest(arrString) {
    _paq.push(['trackEvent', 'Backoffice'].concat(JSON.parse(arrString)));
}

var sideNavTrackingNodes = getTreeTrackingModel(3);

function trackingExplorerTreeNavigation() {
    $(document).on('click', '.yw-navigationNode-level1', function () {
        if (isInExploreTreeContainer($(this))) {
            _paq.push(['trackEvent', 'Backoffice', 'ExplorerTree_Navigation_Level_1',
                getTitle($(this), EXPLORER_TREE_LABEL),
                getValue($(this).attr(CLICK_TRACKING_KEY))]);
        } else if (isInSideNavigationContainer($(this))) {
            reloadSideNavTrackingNodes(0);
            var title = getValue($(this).attr(TITLE));
            var titleKey = getValue($(this).attr(CLICK_TRACKING_KEY));
            sideNavTrackingNodes[0] = new NavigationNode(title, titleKey);
            _paq.push(['trackEvent', 'Backoffice', 'ExplorerTree_Navigation_Level_1', title, titleKey]);
        }
    });

    $(document).on('click', '.yw-navigationNode-level2', function () {
        if (isInExploreTreeContainer($(this))) {
            _paq.push(['trackEvent', 'Backoffice', 'ExplorerTree_Navigation_Level_2',
                `${getValue(getTitle($(this).prevAll(NAVIGATION_NODE_LEVEL1), EXPLORER_TREE_LABEL))} ► ${getTitle($(this), EXPLORER_TREE_LABEL)}`,
                `${getTreeNodeClickTrackingKey($(this), NAVIGATION_NODE_LEVEL1)} ► ${getValue($(this).attr(CLICK_TRACKING_KEY))}`]);
        } else if (isInSideNavigationContainer($(this))) {
            reloadSideNavTrackingNodes(1);
            var title = `${sideNavTrackingNodes[0].title} ► ${getValue($(this).attr(TITLE))}`;
            var titleKey = `${sideNavTrackingNodes[0].titleKey} ► ${getValue($(this).attr(CLICK_TRACKING_KEY))}`;
            sideNavTrackingNodes[1] = new NavigationNode(title, titleKey);
            _paq.push(['trackEvent', 'Backoffice', 'ExplorerTree_Navigation_Level_2', title, titleKey]);
        }
    });

    $(document).on('click', '.yw-navigationNode-level3', function () {
        if (isInExploreTreeContainer($(this))) {
            _paq.push(['trackEvent', 'Backoffice', 'ExplorerTree_Navigation_Level_3',
                `${getValue(getTitle($(this).prevAll(NAVIGATION_NODE_LEVEL1), EXPLORER_TREE_LABEL))} ► `
                + `${getValue(getTitle($(this).prevAll(NAVIGATION_NODE_LEVEL2), EXPLORER_TREE_LABEL))} ► `
                + `${getTitle($(this), EXPLORER_TREE_LABEL)}`,
                `${getTreeNodeClickTrackingKey($(this), NAVIGATION_NODE_LEVEL1)} ► ${getTreeNodeClickTrackingKey($(this), NAVIGATION_NODE_LEVEL2)} ► ${getValue($(this).attr(CLICK_TRACKING_KEY))}`]);
        } else if (isInSideNavigationContainer($(this))) {
            reloadSideNavTrackingNodes(2);
            var title = `${sideNavTrackingNodes[1].title} ► ${getValue($(this).attr(TITLE))}`;
            var titleKey = `${sideNavTrackingNodes[1].titleKey} ► ${getValue($(this).attr(CLICK_TRACKING_KEY))}`;
            sideNavTrackingNodes[2] = new NavigationNode(title, titleKey);
            _paq.push(['trackEvent', 'Backoffice', 'ExplorerTree_Navigation_Level_3', title, titleKey]);
        }
    });
}

function trackingPerspectiveNavigation() {
    $(document).on('click', '.yw-perspective-popup-level0', function () {
        _paq.push(['trackEvent', 'Backoffice', 'Perspective_Navigation',
            getTitle($(this), ".yw-perspective-popup-treecell .z-treecell-text"),
            getValue($(this).attr(CLICK_TRACKING_KEY))]);
    });
}

function trackingActionButtonNavigation() {
    $(document).on('click', '.cng-action-enabled', function () {
        if (isNavigationAction($(this))) {
            _paq.push(['trackEvent', 'Backoffice', 'ActionButton_Navigation',
                getTitle($(this), "span"),
                getValue($(this).attr(CLICK_TRACKING_KEY))]);
        }
    });
}

function trackingShellBarActions() {
    $(document).on('click', '.yw-statusToolbar-right .z-toolbarbutton', function () {
        _paq.push(['trackEvent', 'Backoffice', 'Shellbar_Action_Level_1',
            getShellBarActionTitle($(this)),
            getValue($(this).attr(CLICK_TRACKING_KEY))]);
    });
}

function trackingUserProfileSettings() {
    $(document).on('click', `${USER_PROFILE_SETTINGS}, ${USER_PROFILE_SIGNOUT}`, function () {
        _paq.push(['trackEvent', 'Backoffice', 'Shellbar_Action_Level_2',
            `${getNodeTitle(USER_PROFILE_BTN)} ► ${getTitle($(this), ".z-listcell-content")}`,
            `${getNodeClickTrackingKey(USER_PROFILE_BTN)} ► ${getValue($(this.parentElement).attr(CLICK_TRACKING_KEY))}`]);
    });

    $(document).on('click', '.yw-com_hybris_backoffice_widgets_masterdetail_userprofilesettings .yw-sidebar-item', function () {
        _paq.push(['trackEvent', 'Backoffice', 'Shellbar_Action_Level_3',
            `${getNodeTitle(USER_PROFILE_BTN)} ► ${getUserProfileSettingsTitle()} ► ${getTitle($(this), ".yw-sidebar-item-title")}`,
            `${getNodeClickTrackingKey(USER_PROFILE_BTN)} ► ${getUserProfileSettingsKey()} ► ${getValue($(this).attr(CLICK_TRACKING_KEY))}`]);
    });
}

function isInExploreTreeContainer(element) {
    return element && element.parents() && element.parents(".yw-explorerTree-sideNavigation").length > 0;
}

function isInSideNavigationContainer(element) {
    return element && element.parents() && element.parents(".yw-sideNavigation-container,.yw-sideNavigation-popup").length > 0;
}

function isNavigationAction(element) {
    return element && element.parents() && element.parents(".yw-pcmbackoffice-navibar").length > 0;
}

function getTreeNodeClickTrackingKey(node, level) {
    return node && getValue(node.prevAll(level).attr(CLICK_TRACKING_KEY));
}

function getNodeClickTrackingKey(condition) {
    return getValue(querySelector(condition) && querySelector(condition).getAttribute(CLICK_TRACKING_KEY));
}

function getNodeTitle(condition) {
    return getValue(querySelector(condition) && querySelector(condition).getAttribute(TITLE));
}

function querySelector(condition) {
    return document.querySelector(condition);
}

function getValue(value) {
    return value || "unknown";
}

function findChild(element, condition) {
    var child = null;
    try {
        var childs = element.find(condition);
        child = childs.length > 0 ? childs[0] : null;
    }
    catch (e) {
        console.error(e);
    }
    return child;
}

function getTitle(element, condition) {
    var title = "";
    if (element != null && condition != null) {
        var child = findChild($(element.get(0)), condition);
        title = child ? child.innerHTML : "";
    }
    return getValue(title);
}

function getShellBarActionTitle(element) {
    if (element.attr("title")) {
        return getValue(element.attr("title"));
    } else {
        var child = findChild(element, "button");
        var title = child ? child.getAttribute(TITLE) : "";
        return getValue(title);
    }
}

function getUserProfileSettingsTitle() {
    var userProfileSettingsCaptionContent = querySelector(".yw-modal-userprofilesettings.yw-modal-masterdetail .z-caption-content");
    return userProfileSettingsCaptionContent && userProfileSettingsCaptionContent.innerHTML;
}

function getUserProfileSettingsKey() {
    var userProfileSettingsCaption = querySelector(".yw-modal-userprofilesettings.yw-modal-masterdetail .z-caption");
    return userProfileSettingsCaption && userProfileSettingsCaption.getAttribute(CLICK_TRACKING_KEY);
}

function getTreeTrackingModel(depth) {
    var arr = Array.from({ length: depth });
    arr.fill(new NavigationNode());
    return arr;
}

function reloadSideNavTrackingNodes(level) {
    if (sideNavTrackingNodes && sideNavTrackingNodes.length > level) {
        for (var i = level; i < sideNavTrackingNodes.length; i++) {
            sideNavTrackingNodes[i].reset();
        }
    }
}

function loadPiwikLib() {
    var piwikScript = document.createElement("script");
    piwikScript.type = "text/javascript";
    piwikScript.src = "cng/scripts/vendor/piwik.min.js";
    document.head.appendChild(piwikScript);
}
