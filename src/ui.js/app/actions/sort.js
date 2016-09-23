export function sortBy(criterion) {
  return{
    type: 'SORT_BY',
    payload: criterion
  }
}
