<template>
    <div></div>
</template>

<script>
    const BaseRepository = require('../../repository/BaseRepository');
    const axios = require('axios').default;

    export default{
        name: 'BaseUIComponent',
        data: () => ({
            path: '/path',
            repository: null,
        }),
        created() {
            this.repository = new BaseRepository(axios, this.path)
        },
        methods: {
        },
    }
</script>
