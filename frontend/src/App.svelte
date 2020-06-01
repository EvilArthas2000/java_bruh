<script>
    import {Router, Link, Route} from "svelte-routing";
    import {USER} from './store.js';
    import {doQuery} from './utils.js';
    import TemplateEntity from "./Components/TemplateEntity/TemplateEntity.svelte";
    import Navbar from "./Components/Navbar/Navbar.svelte";
    import GoodTable from "./Components/GoodTable/GoodTable.svelte";
    import GoodCreate from "./Components/GoodCreate/GoodCreate.svelte";
    import GoodEdit from "./Components/GoodEdit/GoodEdit.svelte";
    import SaleTable from "./Components/SaleTable/SaleTable.svelte";
    import SaleCreate from "./Components/SaleCreate/SaleCreate.svelte";
    import SaleEdit from "./Components/SaleEdit/SaleEdit.svelte";
    import Warehouse1Table from "./Components/Warehouse1Table/Warehouse1Table.svelte";
    import Warehouse1Create from "./Components/Warehouse1Create/Warehouse1Create.svelte";
    import Warehouse1Edit from "./Components/Warehouse1Edit/Warehouse1Edit.svelte";
    import Warehouse2Table from "./Components/Warehouse2Table/Warehouse2Table.svelte";
    import Warehouse2Create from "./Components/Warehouse2Create/Warehouse2Create.svelte";
    import Warehouse2Edit from "./Components/Warehouse2Edit/Warehouse2Edit.svelte";

    import {onMount} from 'svelte';
    import Registration from "./Components/Registreation/Registration.svelte";

    let mounted = false;

    onMount(() => {
        doQuery('/user')
                .then(response => response.json())
                .then(json => {
                    USER.set(json);
                })
                .catch(() => {
                    USER.set(null);
                })
                .finally(() => {
                    mounted = true;
                });
    });
</script>

<svelte:head>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</svelte:head>

{#if mounted}

    <Router>
        <header>
            <Navbar/>
        </header>

        <main>
            {#if $USER != null}
                <Route path="/warehouse2">
                    <TemplateEntity name="Warehouse2" isCreate>
                        <div slot="inner">
                            <Warehouse2Table/>
                        </div>
                    </TemplateEntity>
                </Route>

                <Route path="/warehouse2/:id" let:params>
                    <TemplateEntity name="Warehouse2">
                        <div slot="inner">
                            <Warehouse2Edit id={params.id}/>
                        </div>
                    </TemplateEntity>
                </Route>

                <Route path="/warehouse2_create">
                    <TemplateEntity name="Warehouse2">
                        <div slot="inner">
                            <Warehouse2Create/>
                        </div>
                    </TemplateEntity>
                </Route>

                <Route path="/warehouse1">
                    <TemplateEntity name="Warehouse1" isCreate>
                        <div slot="inner">
                            <Warehouse1Table/>
                        </div>
                    </TemplateEntity>
                </Route>

                <Route path="/warehouse1/:id" let:params>
                    <TemplateEntity name="Warehouse1">
                        <div slot="inner">
                            <Warehouse1Edit id={params.id}/>
                        </div>
                    </TemplateEntity>
                </Route>

                <Route path="/warehouse1_create">
                    <TemplateEntity name="Warehouse1" isCreate>
                        <div slot="inner">
                            <Warehouse1Create/>
                        </div>
                    </TemplateEntity>
                </Route>


                <Route path="/sale">
                    <TemplateEntity name="Sale" isCreate>
                        <div slot="inner">
                            <SaleTable/>
                        </div>
                    </TemplateEntity>
                </Route>

                <Route path="/sale/:id" let:params>
                    <TemplateEntity name="Sale">
                        <div slot="inner">
                            <SaleEdit id={params.id}/>
                        </div>
                    </TemplateEntity>
                </Route>

                <Route path="/sale_create">
                    <TemplateEntity name="Sale">
                        <div slot="inner">
                            <SaleCreate/>
                        </div>
                    </TemplateEntity>
                </Route>


                <Route path="/good">
                    <TemplateEntity name="Good" isCreate>
                        <div slot="inner">
                            <GoodTable/>
                        </div>
                    </TemplateEntity>
                </Route>

                <Route path="/good/:id" let:params>
                    <TemplateEntity name="Good" isCreate>
                        <div slot="inner">
                            <GoodEdit id={params.id}/>
                        </div>
                    </TemplateEntity>
                </Route>

                <Route path="/good_create">
                    <TemplateEntity name="Good">
                        <div slot="inner">
                            <GoodCreate/>
                        </div>
                    </TemplateEntity>
                </Route>

                <Route path="/good">
                    <TemplateEntity name="Good" isCreate>
                        <div slot="inner">
                            <GoodTable/>
                        </div>
                    </TemplateEntity>
                </Route>
            {:else}
                <Route path="/registration" component={Registration}/>
            {/if}

            <Route path="/">
                <div>
                    Курсовой проект. Вариант 3
                </div>
            </Route>
        </main>
    </Router>

{/if}

<style>
    main {
        width: 100%;
        height: 100%;
        box-sizing: border-box;
        padding: 1em;
    }
</style>