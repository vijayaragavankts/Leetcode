class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> filteredRestaurants = new ArrayList<>();
        
        for (int[] restaurant : restaurants) {
            if ((veganFriendly == 0 || restaurant[2] == veganFriendly) && 
                restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                filteredRestaurants.add(restaurant);
            }
        }

        // Sort the filtered list by rating (descending), and by ID (descending) if ratings are equal
        Collections.sort(filteredRestaurants, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return b[1] - a[1]; // Sort by rating descending
                } else {
                    return b[0] - a[0]; // Sort by id descending if ratings are equal
                }
            }
        });

        // Extract the IDs of the restaurants
        List<Integer> result = new ArrayList<>();
        for (int[] restaurant : filteredRestaurants) {
            result.add(restaurant[0]);
        }

        return result;
    }
}