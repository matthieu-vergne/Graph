package fr.vergne.graph.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import fr.vergne.graph.Arc;
import fr.vergne.graph.Tree;

public class ImmutableTree<CVertex, CArc extends Arc<? extends CVertex>>
		extends ImmutableGraph<CVertex, CArc> implements Tree<CVertex, CArc> {

	private final Collection<? extends CArc> arcs;
	private final CVertex root;

	public ImmutableTree(Collection<? extends CArc> arcs) {
		super(extractVerticesFrom(arcs), arcs);
		this.arcs = Collections.unmodifiableSet(new HashSet<CArc>(arcs));
		this.root = checkAndExtractRootFrom(arcs);
	}

	@SuppressWarnings("unchecked")
	public ImmutableTree(CVertex singleNode) {
		super(Arrays.asList(singleNode), Collections.<CArc> emptyList());
		this.arcs = Collections.emptySet();
		this.root = singleNode;
	}

	private static <CVertex, CArc extends Arc<? extends CVertex>> Collection<CVertex> extractVerticesFrom(
			Collection<? extends CArc> arcs) {
		Collection<CVertex> vertices = new HashSet<CVertex>();
		for (Arc<? extends CVertex> arc : arcs) {
			vertices.addAll(arc.getVertices());
		}
		return vertices;
	}

	private CVertex checkAndExtractRootFrom(Collection<? extends CArc> arcs) {
		List<CArc> todo = new ArrayList<CArc>(arcs);
		Collection<CVertex> alreadyBrowsed = new HashSet<CVertex>();
		Collection<CVertex> roots = new HashSet<CVertex>();
		boolean hasBeenExtended;
		do {
			hasBeenExtended = false;
			Iterator<CArc> iterator = todo.iterator();
			while (iterator.hasNext()) {
				Arc<? extends CVertex> arc = iterator.next();
				if (alreadyBrowsed.containsAll(arc.getVertices())) {
					throw new IllegalArgumentException("The arc " + arc
							+ " appears to close a cycle in " + arcs);
				} else if (!alreadyBrowsed.isEmpty()
						&& Collections.disjoint(alreadyBrowsed,
								arc.getVertices())) {
					// not an arc extending the tree, let it for later
				} else {
					if (roots.isEmpty()) {
						roots.add(arc.getStart());
					} else if (roots.contains(arc.getStop())) {
						roots.remove(arc.getStop());
						roots.add(arc.getStart());
					} else if (alreadyBrowsed.contains(arc.getStart())) {
						// already valid roots
					} else {
						throw new RuntimeException(
								"This case should not happen");
					}
					alreadyBrowsed.addAll(arc.getVertices());// one added
					iterator.remove();
					hasBeenExtended = true;
				}
			}
		} while (hasBeenExtended);

		if (!todo.isEmpty()) {
			throw new IllegalArgumentException(
					"More than a single tree is provided in the arcs " + arcs);
		} else if (roots.size() > 1) {
			throw new IllegalArgumentException("There is more than 1 root: "
					+ roots);
		} else if (roots.size() < 1) {
			return null;
		} else {
			return roots.iterator().next();
		}
	}

	public CVertex getRoot() {
		return root;
	}

	public ChildrenIterator<CVertex> getChildrenOf(CVertex vertex) {
		return new DefaultChildrenIterator<CVertex>(vertex, arcs);
	}

	public static class DefaultChildrenIterator<CVertex> implements
			ChildrenIterator<CVertex> {

		private final Iterator<? extends Arc<? extends CVertex>> arcIterator;
		private final CVertex parent;
		private CVertex nextChild;

		public DefaultChildrenIterator(CVertex parent,
				Collection<? extends Arc<? extends CVertex>> arcs) {
			this.parent = parent;
			this.arcIterator = arcs.iterator();
			lookForNextChild();
		}

		private void lookForNextChild() {
			nextChild = null;
			while (nextChild == null && arcIterator.hasNext()) {
				Arc<? extends CVertex> arc = arcIterator.next();
				if (arc.getStart().equals(parent)) {
					nextChild = arc.getStop();
				} else {
					// irrelevant arc, just ignore
				}
			}
		}

		@Override
		public Iterator<CVertex> iterator() {
			return this;
		}

		@Override
		public boolean hasNext() {
			return nextChild != null;
		}

		@Override
		public CVertex next() {
			CVertex child = nextChild;
			lookForNextChild();
			return child;
		}

		@Override
		public void remove() {
			throw new IllegalStateException("The tree is immutable.");
		}
	}
}
