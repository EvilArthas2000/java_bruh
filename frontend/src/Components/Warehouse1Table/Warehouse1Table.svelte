<script>
    import {onMount} from 'svelte';
    import {doQuery} from "../../utils";
    import {link} from 'svelte-routing';

    let warehouse1List = Array();

    onMount(() => {
        doQuery('/api/warehouse1')
                .then(response => response.json())
                .then(json => {
                    warehouse1List = Array.from(json);
                });
    });

    function handleDelete(id) {
        doQuery(`/api/warehouse1/${id}`, {
            method: 'DELETE'
        })
                .then(() => {
                    warehouse1List = warehouse1List.filter(good => good.id !== id);
                });
    }
</script>

<table class="table">
    <thead>
    <tr>
        <th>Good</th>
        <th>Good Count</th>
    </tr>
    </thead>
    <tbody>

    {#each warehouse1List as warehouse}
        <tr>
            <td>{warehouse.good.name}</td>
            <td>{warehouse.good_count}</td>
            <td><a href="/warehouse1/{warehouse.id}" use:link>Edit</a></td>
            <td><a on:click={() => handleDelete(warehouse.id)} href="#">Delete</a></td>
        </tr>
    {/each}
    </tbody>
</table>
