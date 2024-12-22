from solution import ListNode, Solution

def create_list(arr):
    """Helper function to create linked list from array"""
    if not arr:
        return None
    head = ListNode(arr[0])
    current = head
    for val in arr[1:]:
        current.next = ListNode(val)
        current = current.next
    return head

def list_to_array(head):
    """Helper function to convert linked list to array for testing"""
    result = []
    current = head
    while current:
        result.append(current.val)
        current = current.next
    return result

def print_list(head):
    """Helper function to print linked list"""
    print("->".join(map(str, list_to_array(head))) + "->null" if head else "null")

def run_tests():
    solution = Solution()
    
    # Test Case 1: Normal case with multiple nodes
    print("\nTest Case 1: Normal list")
    test1 = create_list([1, 2, 3, 4, 5])
    print("Original:", end=" ")
    print_list(test1)
    print("Reversed:", end=" ")
    print_list(solution.ReverseList(test1))
    print("Expected: 5->4->3->2->1->null")

    # Test Case 2: Single node
    print("\nTest Case 2: Single node")
    test2 = create_list([1])
    print("Original:", end=" ")
    print_list(test2)
    print("Reversed:", end=" ")
    print_list(solution.ReverseList(test2))
    print("Expected: 1->null")

    # Test Case 3: Empty list
    print("\nTest Case 3: Empty list")
    test3 = None
    print("Original:", end=" ")
    print_list(test3)
    print("Reversed:", end=" ")
    print_list(solution.ReverseList(test3))
    print("Expected: null")

    # Test Case 4: Two nodes
    print("\nTest Case 4: Two nodes")
    test4 = create_list([1, 2])
    print("Original:", end=" ")
    print_list(test4)
    print("Reversed:", end=" ")
    print_list(solution.ReverseList(test4))
    print("Expected: 2->1->null")

    # Test Case 5: Nodes with negative values
    print("\nTest Case 5: Negative values")
    test5 = create_list([-1, 0, 1, -2, 2])
    print("Original:", end=" ")
    print_list(test5)
    print("Reversed:", end=" ")
    print_list(solution.ReverseList(test5))
    print("Expected: 2->-2->1->0->-1->null")

if __name__ == "__main__":
    run_tests() 