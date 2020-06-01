<script>
    import {onMount} from 'svelte';
    import {doQuery} from "../../utils";
    import {link} from 'svelte-routing';

    let saleList = Array();

    onMount(() => {
        doQuery('/api/sale')
                .then(response => response.json())
                .then(json => {
                    saleList = Array.from(json);
                });
    });

    function handleDelete(id) {
        doQuery(`/api/sale/${id}`, {
            method: 'DELETE'
        })
                .then(() => {
                    saleList = saleList.filter(good => good.id !== id);
                });
    }
</script>

<table class="table">
    <thead>
    <tr>
        <th>Good</th>
        <th>Good count</th>
        <th>Create date</th>
    </tr>
    </thead>
    <tbody>

    {#each saleList as saleService}
        <tr>
            <td>{saleService.good.name}</td>
            <td>{saleService.good_count}</td>
            <td>{saleService.createDate}</td>
            <td><a href="/sale/{saleService.id}" use:link>Edit</a></td>
            <td><a on:click={() => handleDelete(saleService.id)} href="#">Delete</a></td>
        </tr>
    {/each}
    </tbody>
</table>