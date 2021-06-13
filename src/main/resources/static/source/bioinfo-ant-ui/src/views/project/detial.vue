<template>
  <a-descriptions :title="data.name" bordered>
    <!-- <a-descriptions-item label="创建时间">
      2018-04-24 18:00:00
    </a-descriptions-item>
    <a-descriptions-item label="更新时间">
      Prepaid
    </a-descriptions-item>
    <a-descriptions-item label="截止时间">
      YES
    </a-descriptions-item>-->
    <a-descriptions-item label="创建时间">{{data.createDate}}</a-descriptions-item>
    <a-descriptions-item label="更新时间">{{data.updateDate}}</a-descriptions-item>
    <a-descriptions-item label="截止时间">{{data.deadline}}</a-descriptions-item>
    <a-descriptions-item label="完成状态" :span="3">
      <a-badge status="processing" :text="data.projectStatus" />
    </a-descriptions-item>
    <!-- <a-descriptions-item label="Discount">
      $20.00
    </a-descriptions-item>
    <a-descriptions-item label="Official Receipts">
      $60.00
    </a-descriptions-item>-->
    <a-descriptions-item label="jupyter结果报告" :span="3">{{data.jupyterUrl}}</a-descriptions-item>
    <!-- <a-descriptions-item label="生成图片" :span="3">{{data.description}}</a-descriptions-item> -->
    <a-descriptions-item label="项目描述" :span="3">{{data.description}}</a-descriptions-item>
  </a-descriptions>
</template>
<script>
import ProjectAPi from "@/api/Project.js";
export default {
  data() {
    return {
      projectId: null,
      data: {}
    };
  },
  beforeRouteEnter(to, from, next) {
    // Get post id from query
    const projectId = to.query.projectId;

    next(vm => {
      if (projectId) {
        vm.projectId = projectId;
        ProjectAPi.findById(projectId).then(response => {
          const project = response.data.data;
          console.log(project);
          vm.data = project;
        });
      }
    });
  }
};
</script>