<script>
    import {onMount} from 'svelte';
    import {doQuery} from "../../utils";

    let name;
    let priority;
    let moundet = false;
    let good = null;

    export let id;

    onMount(() => {
        doQuery(`/api/good/${id}`)
                .then(response => response.json())
                .then(json => {
                    good = json;
                    moundet = true;
                });
    });

    function handleSubmit() {
        const json = JSON.stringify({
            name: name,
            priority: priority
        })

        doQuery(`/api/good/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: json
        });
    }
</script>

{#if moundet}
    <form class="uk-form-stacked">
        <form on:submit={handleSubmit}>
            <div class="input-group">

                <input class="form-control" type="text" placeholder="Name: {good.name}" required
                       bind:value={name}/>
            </div>

            <div class="input-group">
                <input class="form-control" type="number" placeholder="Priority: {good.priority}"
                       min="0" required
                       bind:value={priority}/>
            </div>

            <div class="input-group">
                <button class="btn btn-outline-primary" type="submit">Изменить</button>
            </div>
        </form>
    </form>
{/if}
