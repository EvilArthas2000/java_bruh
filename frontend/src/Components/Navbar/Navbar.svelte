<script>
    import {link} from 'svelte-routing';
    import {USER} from '../../store.js';
</script>

<nav class="navbar navbar-expand-lg navbar-light bg-white">
    <a class="navbar-brand" href="/">Home</a>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ">
            {#if $USER != null}
                <li class="nav-item">
                    <a class="nav-link" href="/good" use:link>Goods</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/sale" use:link>Sales</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/warehouse1" use:link>Warehouse 1</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/warehouse2" use:link>Warehouse 2</a>
                </li>
            {/if}
        </ul>

        <ul class="right navbar-nav gap">
            {#if $USER !== null}
                <li class="nav-item">
                    <a href="/logout">Log out</a>
                </li>
            {:else}
                <li class="nav-item">
                    <a  href="/registration" use:link>Registration</a>
                </li>

                <li class="nav-item">
                    <a  href="/login">Login</a>
                </li>
            {/if}
        </ul>
    </div>
</nav>

<style>
    .right {
        margin-left: auto;
    }
    .gap {
        display: grid;
        grid-auto-flow: column;
        gap: 0 1em;
    }
</style>
