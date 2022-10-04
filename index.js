class NavBar extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <nav>
                <ul>
                    <li><a href="ingredients.php">Recipe Finder</a></li>
                    <li><a href="SpecialHealthPage.html">Health Issues/Dietary Preferences</a></li>
                </ul>
            </nav>
        `;
    }
}

customElements.define('main-header', NavBar);