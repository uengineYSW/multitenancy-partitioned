<template>
    <div style="margin: -10px -15px 0 -15px;">
        <v-card-text>
            <div class="label-title"></div>
            <div v-if="editMode">
                <v-select
                    v-model="newValue"
                    :label="label"
                    :items="salestypeList"
                    solo
                ></v-select>
            </div>
            <div v-else>
                SalesType : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity.vue';

export default {
    name: 'SalesType',
    mixins:[BaseEntity],
    components:{},
    props: {
        label: String
    },
    data: () => ({
        salestypeList : [ "PO",  "SA",  "PM", ],
        newValue: '',
    }),
    async created() {
        if(!this.value) {
            this.newValue = this.salestypeList[0];
        } else {
            this.newValue = this.value;
        }
    },
    watch: {
        value(val) {
            this.$emit('input', val);
        },
        newValue(val) {
            this.$emit('input', val);
        },
    },
    methods: {
    }
}
</script>

