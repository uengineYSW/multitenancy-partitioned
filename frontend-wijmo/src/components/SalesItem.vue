<template>

    <div>
        <div class="detail-title">
        SalesItem
        </div>
        <v-col>
            <String label="ProductId" v-model="value.productId" :editMode="editMode"/>
            <String label="Qty" v-model="value.qty" :editMode="editMode"/>
            <String label="Price" v-model="value.price" :editMode="editMode"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'SalesItem',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: 'SalesItems',
    }),
    props: {
        Editable: Boolean,
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
            this.Editable = false
        },
    },
    async created(){
        if (this.value && this.value.id !== undefined) {
            this.value = await this.repository.findById(this.value.id)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
        EditableClick(){
            if(this.editMode == true) {
                this.Editable = true
            }
        }
    }
}
</script>

