import service from '@/utils/service'
const baseUrl = '/api/user'

const RoleApi = {}

RoleApi.page = (params) =>{
    return service({
        url: `${baseUrl}`,
        params: params,
        method: 'get'
    })
}



export default RoleApi