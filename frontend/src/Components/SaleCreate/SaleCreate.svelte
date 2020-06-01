<script>
    import {onMount} from 'svelte';
    import {doQuery} from "../../utils";

    let goodId;
    let good_count;
    let createDate;
    let goodList = Array();

    onMount(() => {
        doQuery('/api/good')
                .then(response => response.json())
                .then(json => {
                    goodList = Array.from(json);
                    goodId = goodList.length === 0 ? goodId : goodList[0].id;
                });
    })

    function handleSubmit() {
        const json = JSON.stringify({
            good: goodList.find(good => good.id == goodId),
            good_count: good_count,
            createDate: createDate
        })

        doQuery('/api/sale', {
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
            <div>
                <label>Good</label>
                <select required bind:value={goodId}>
                    {#each goodList as good}
                        <option value={good.id}>{good.name}</option>
                    {/each}
                </select>
            </div>
        </div>


        <div class="uk-margin">
            <input class="form-control" type="number" placeholder="Good count" min="0" required
                   bind:value={good_count}/>
        </div>

        <div class="uk-margin">
            <label>Create Date</label>
            <br/>
            <input class="form-control" type="datetime-local" required
                   bind:value={createDate}/>
        </div>

        <div class="uk-margin">
            <button class="btn btn-outline-primary" type="submit">Создать</button>
        </div>
    </form>
</form>


