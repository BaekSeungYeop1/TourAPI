<template>
<div id="app">
	<v-app>
		<div class="text-center">
			<v-card class="mt-4 mb-4 mx-auto" max-width="200" v-for="(item, index) in historyList" :key="index">
				<v-img class="white--text align-end" height="150px" :lazy-src="item.image">
					<v-card-title>{{item.title}}</v-card-title>
				</v-img>
				<v-card-text class="text--primary">
					<div>{{item.description}}</div>
				</v-card-text>
			</v-card>
			<v-pagination class="pagination mb-2" v-model="page" :length="pages" @input="updatePage"></v-pagination>
		</div>
	</v-app>
</div>    
</template>

<script>
export default {
    data() {
		return {
			page: 1,
			pageSize: 2,
			list: [
				{
					title: "Title 1",
					description: "Content 1",
					image:
						"https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 2",
					description: "Content 2",
					image:
						"https://images.unsplash.com/photo-1415369629372-26f2fe60c467?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 3",
					description: "Content 3",
					image:
						"https://images.unsplash.com/photo-1548681528-6a5c45b66b42?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 4",
					description: "Content 4",
					image:
						"https://images.unsplash.com/photo-1548247416-ec66f4900b2e?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 5",
					description: "Content 5",
					image:
						"https://images.unsplash.com/photo-1513360371669-4adf3dd7dff8?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
                {
					title: "Title 1",
					description: "Content 1",
					image:
						"https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 2",
					description: "Content 2",
					image:
						"https://images.unsplash.com/photo-1415369629372-26f2fe60c467?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 3",
					description: "Content 3",
					image:
						"https://images.unsplash.com/photo-1548681528-6a5c45b66b42?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 4",
					description: "Content 4",
					image:
						"https://images.unsplash.com/photo-1548247416-ec66f4900b2e?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 5",
					description: "Content 5",
					image:
						"https://images.unsplash.com/photo-1513360371669-4adf3dd7dff8?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
                {
					title: "Title 1",
					description: "Content 1",
					image:
						"https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 2",
					description: "Content 2",
					image:
						"https://images.unsplash.com/photo-1415369629372-26f2fe60c467?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 3",
					description: "Content 3",
					image:
						"https://images.unsplash.com/photo-1548681528-6a5c45b66b42?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 4",
					description: "Content 4",
					image:
						"https://images.unsplash.com/photo-1548247416-ec66f4900b2e?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 5",
					description: "Content 5",
					image:
						"https://images.unsplash.com/photo-1513360371669-4adf3dd7dff8?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
                {
					title: "Title 1",
					description: "Content 1",
					image:
						"https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 2",
					description: "Content 2",
					image:
						"https://images.unsplash.com/photo-1415369629372-26f2fe60c467?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 3",
					description: "Content 3",
					image:
						"https://images.unsplash.com/photo-1548681528-6a5c45b66b42?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 4",
					description: "Content 4",
					image:
						"https://images.unsplash.com/photo-1548247416-ec66f4900b2e?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 5",
					description: "Content 5",
					image:
						"https://images.unsplash.com/photo-1513360371669-4adf3dd7dff8?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
                {
					title: "Title 1",
					description: "Content 1",
					image:
						"https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 2",
					description: "Content 2",
					image:
						"https://images.unsplash.com/photo-1415369629372-26f2fe60c467?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 3",
					description: "Content 3",
					image:
						"https://images.unsplash.com/photo-1548681528-6a5c45b66b42?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 4",
					description: "Content 4",
					image:
						"https://images.unsplash.com/photo-1548247416-ec66f4900b2e?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				},
				{
					title: "Title 5",
					description: "Content 5",
					image:
						"https://images.unsplash.com/photo-1513360371669-4adf3dd7dff8?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ"
				}
			],
			listCount: 0,
			historyList: []
		};
	},
	created() {
		let _this = this;
		_this.initPage();
		_this.updatePage(_this.page);
	},
	methods: {
		initPage: function() {
			let _this = this;
			_this.listCount = _this.list.length;
			if (_this.listCount < _this.pageSize) {
				_this.historyList = _this.list;
			} else {
				_this.historyList = _this.list.slice(0, _this.pageSize);
			}
		},
		updatePage: function(pageIndex) {
			let _this = this;
			let _start = (pageIndex - 1) * _this.pageSize;
			let _end = pageIndex * _this.pageSize;
			_this.historyList = _this.list.slice(_start, _end);
			_this.page = pageIndex;
		}
	},
	computed: {
		pages() {
			let _this = this;
			if (_this.pageSize == null || _this.listCount == null) return 0;
			return Math.ceil(_this.listCount / _this.pageSize);
		}
	},
};
    
</script>

