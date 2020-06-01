<script>
    import {onMount} from 'svelte';
    import {doQuery} from "../../utils";

    let name;
    let priority;

    function handleSubmit() {
        const json = JSON.stringify({
            name: name,
            priority: priority
        })

        doQuery('/api/good', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: json
        });
    }
</script>

<form class="uk-form-stacked">
    <form on:submit={handleSubmit}>

        <div class="uk-margin">
            <input class="form-control" type="text" placeholder="Name" required bind:value={name}/>
        </div>

        <div class="uk-margin">
            <input class="form-control" type="number" placeholder="Priority" min="0" required
                   bind:value={priority}/>
        </div>

        <div class="uk-margin">
            <button class="btn btn-outline-primary" type="submit">Создать</button>
        </div>
    </form>
</form>


